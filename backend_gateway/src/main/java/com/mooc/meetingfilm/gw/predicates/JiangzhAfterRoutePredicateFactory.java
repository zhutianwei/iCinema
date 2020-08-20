package com.mooc.meetingfilm.gw.predicates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import javax.validation.constraints.NotEmpty;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author : Z
 * @program : com.springcloud.gatewaydemo.predicates
 * @description : 日期路由自定义
 **/
// 一定一定要注意：RoutePredicateFactory为结尾
public class ZAfterRoutePredicateFactory extends AbstractRoutePredicateFactory<ZAfterRoutePredicateFactory.Config> {
    public static final String AFTER_KEY = "datetime";
    /**
     * @Description:  传入配置信息
     * @Param: []
     * @return:
     * @Author: Z
     */
    public ZAfterRoutePredicateFactory() {
        super(ZAfterRoutePredicateFactory.Config.class);
    }

    /**
     * @Description: 参数列表与Config属性之间的映射
     * @Param: []
     * @return: java.util.List<java.lang.String>
     * @Author: Z
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList(AFTER_KEY);
    }
    /**
     * @Description: 具体的路由匹配逻辑
     * @Param: [config]
     * @return: java.util.function.Predicate<org.springframework.web.server.ServerWebExchange>
     * @Author: Z
     */
    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        System.out.println("ZAfterRoutePredicateFactory -> config : "+config);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        long nowTime = System.currentTimeMillis();
        return (exchange) -> {
            // 解析出配置定义的时间
            long afterTime = 0;
            try {
                afterTime = format.parse(config.getDatetime()).getTime();
            } catch (ParseException e) {
                return false;
            }
            // 如果当前时间大于配置定义时间，则返回true
            return nowTime > afterTime;
        };
    }

    /**
     * @Description: 用于承载断言所需的参数
     * @Param: 我们这里是判断输入的时间与真实时间之间的先后关系
     * @Author: Z
     */
    public static class Config {
        @NotEmpty
        private String datetime;

        public Config() {
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }

}