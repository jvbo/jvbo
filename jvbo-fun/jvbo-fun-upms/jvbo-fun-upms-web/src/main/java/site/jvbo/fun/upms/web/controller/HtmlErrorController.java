package site.jvbo.fun.upms.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2018/10/26
 */
@ApiIgnore
@Api(tags = "默认错误页面", description = "默认错误页面")
@Controller
@RequestMapping("/error")
@EnableConfigurationProperties({ServerProperties.class})
public class HtmlErrorController implements ErrorController {
	private ErrorAttributes errorAttributes;

	@Autowired
	private ServerProperties serverProperties;

	/**
	 * 初始化ExceptionController
	 *
	 * @param errorAttributes
	 */
	@Autowired
	public HtmlErrorController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	@ApiIgnore
	@ApiOperation(value = "401")
	@RequestMapping(produces = "text/html", value = "400")
	public ModelAndView errorHtml400(HttpServletRequest request,
									 HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("400", model);
	}

	@ApiIgnore
	@ApiOperation(value = "403")
	@RequestMapping(produces = "text/html", value = "403")
	public ModelAndView errorHtml403(HttpServletRequest request,
									 HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("403", model);
	}

	@ApiIgnore
	@ApiOperation(value = "404")
	@RequestMapping(produces = "text/html", value = "404")
	public ModelAndView errorHtml404(HttpServletRequest request,
									 HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("404", model);
	}

	@ApiIgnore
	@ApiOperation(value = "500")
	@RequestMapping(produces = "text/html", value = "500")
	public ModelAndView errorHtml500(HttpServletRequest request,
									 HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("500", model);
	}

	/**
	 * Determine if the stacktrace attribute should be included.
	 *
	 * @param request  the source request
	 * @param produces the media type produced (or {@code MediaType.ALL})
	 * @return if the stacktrace attribute should be included
	 */
	protected boolean isIncludeStackTrace(HttpServletRequest request,
										  MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}


	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
												   boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}

	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	@Override
	public String getErrorPath() {
		return "";
	}
}
