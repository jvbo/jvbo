<script type="text/javascript">
	$(function(){
		$("#treeUl").tree({
			url:ctx+'/sys/user/roleTree.ajax?userId='+id,
			checkbox:true,
			onBeforeExpand: function (node){
				$(this).tree("options").url=ctx+'/sys/user/roleTree.ajax?id='+node.id+'&user='+id;
			},
			onLoadSuccess:function(node,data){
				 var t = $(this);
				 if(data){
					  $(data).each(function(index, d) {
	                    if (this.state == 'closed') {
	                        t.tree('expandAll');
	                    }
	                });
	                 $("#treeUl").tree("collapseAll");
	                 if($("#treeUl").tree('getChildren').length>0)
	     				$("#treeUl").tree('getChildren').tree("collapseAll");
	             }
	            	 
			}
			
		});
	
	});
	

</script>

<ul id="treeUl">

</ul>
