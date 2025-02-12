package leetcode.Proxy;

public class SendMessage {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) ProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("test invocationHandler");
    }

}
