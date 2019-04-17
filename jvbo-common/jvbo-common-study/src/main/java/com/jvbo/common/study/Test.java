package com.jvbo.common.study;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * @ClassName:
 * @Description: TODO
 * @author: jvbo
 * @date: 2019/3/12
 */
public class Test {

    /**
     * 新建钱包文件keyfile
     * @throws NoSuchAlgorithmException
     * @throws NoSuchProviderException
     * @throws InvalidAlgorithmParameterException
     * @throws CipherException
     * @throws IOException
     */
    private static void creatAccount() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException {
        String walletFileName0="";//文件名
        String walletFilePath0="D:/temp/";
        //钱包文件保持路径，请替换位自己的某文件夹路径

        walletFileName0 = WalletUtils.generateNewWalletFile("123456", new File(walletFilePath0), false);
        System.out.println("walletName: "+walletFileName0);
    }

    /**
     * 加载钱包文件
     * @throws IOException
     * @throws CipherException
     */
    public static void loadWallet() throws IOException, CipherException {
        String walleFilePath="D:/temp/UTC--2019-03-12T14-28-56.323000000Z--8fdd4d95dd44cae8ff584140cb83556dc6656b1e.json";
        String passWord="123456";
        Credentials credentials = WalletUtils.loadCredentials(passWord, walleFilePath);
        String address = credentials.getAddress();
        BigInteger publicKey = credentials.getEcKeyPair().getPublicKey();
        BigInteger privateKey = credentials.getEcKeyPair().getPrivateKey();

        System.out.println("address="+address);
        System.out.println("public key="+publicKey);
        System.out.println("private key="+privateKey);

    }

    /**
     * 连接以太坊客户端
     * @throws IOException
     */
    public static void conectETHclient() throws IOException {
        //连接方式1：使用infura 提供的客户端
        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/zmd7VgRt9go0x6qlJ2Mk"));// TODO: 2018/4/10 token更改为自己的
        //连接方式2：使用本地客户端
        //web3j = Web3j.build(new HttpService("127.0.0.1:7545"));
        //测试是否连接成功
        String web3ClientVersion = web3j.web3ClientVersion().send().getWeb3ClientVersion();
        System.out.println("version=" + web3ClientVersion);
    }

    /**
     * 查询账户余额
     * @throws IOException
     */
    public static void getBlanceOf(String mainHttp, String address) throws IOException {
        Web3j web3j = Web3j.build(new HttpService(mainHttp));// TODO: 2018/4/10 token更改为自己的
        if (web3j == null) return;
        //第二个参数：区块的参数，建议选最新区块
        EthGetBalance balance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        //格式转化 wei-ether
        String blanceETH = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER).toPlainString().concat(" ether");
        System.out.println(blanceETH);
    }

    private void transto() throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/zmd7VgRt9go0x6qlJ2Mk"));// TODO: 2018/4/10 token更改为自己的
        String walleFilePath="D:/temp/UTC--2019-03-12T14-28-56.323000000Z--8fdd4d95dd44cae8ff584140cb83556dc6656b1e.json";
        String passWord="123456";
        Credentials credentials = WalletUtils.loadCredentials(passWord, walleFilePath);

        if (web3j == null) return;
        if (credentials == null) return;
        //开始发送0.01 =eth到指定地址
        String address_to = "0x41F1dcbC0794BAD5e94c6881E7c04e4F98908a87";
        TransactionReceipt send = Transfer.sendFunds(web3j, credentials, address_to, BigDecimal.ONE, Convert.Unit.ETHER).send();

        System.out.println("Transaction complete:");
        System.out.println("trans hash=" + send.getTransactionHash());
        System.out.println("from :" + send.getFrom());
        System.out.println("to:" + send.getTo());
        System.out.println("gas used=" + send.getGasUsed());
        System.out.println("status: " + send.getStatus());
    }

    public static void main(String[] args) throws CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
        //creatAccount();
        // loadWallet(); // 新创建的钱包地址: 0x8fdd4d95dd44cae8ff584140cb83556dc6656b1e
        // 已经余额的钱包地址: 0x683d7d8536b67dce9fa2f3d2b64eaa2969d8cfc6
        String fromAdress = "0x683d7d8536b67dce9fa2f3d2b64eaa2969d8cfc6"; // 已经余额的钱包地址
        String toAdress = "0x8fdd4d95dd44cae8ff584140cb83556dc6656b1e"; //新创建的钱包地址
        // 主网地址
        String mainHttp = "https://mainnet.infura.io/v3/5643303661bc44fea37345d17703180f";
        //getBlanceOf(mainHttp, toAdress);
        getBlanceOf(mainHttp, fromAdress); // 0.008335197112918649 ether
        //transto();

        // 这里zxc/eth需要每隔2小时更新一下汇率;
        // https://www.ceo.bi/api/market/ticker?market=zxc_qc
        // https://www.ceo.bi/api/market/ticker?market=eth_qc
        // 把zxc转成eth
    }
}
