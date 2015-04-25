package com.springindepth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.util.ReflectionUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

/**
 * Created by jiazhong on 2015/4/21.
 */
public class DoublerBeanPostProcessor implements BeanPostProcessor, Ordered {

    final Logger logger = LoggerFactory.getLogger(DoublerBeanPostProcessor.class);

    /**
     * Implementation of <code>Ordered</code> interface.
     */
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    /**
     * Process before bean initialization.
     */
    public Object postProcessBeforeInitialization(final Object bean, String beanName) throws BeansException {
        logger.debug("Doubler before initialization of '" + beanName + "' bean.");

        Class clazz = bean.getClass();

        ReflectionUtils.doWithMethods(clazz, new ReflectionUtils.MethodCallback() {
            public void doWith(Method method) {
                if (method.isAnnotationPresent(Doubler.class)) {
                    try {
                        PropertyDescriptor pd = BeanUtils.findPropertyForMethod(method);

                        int originalValue = (Integer) pd.getReadMethod().invoke(bean, null);
                        int doubledValue = originalValue * 2;

                        // set doubled value
                        pd.getWriteMethod().invoke(bean, new Object[]{doubledValue});

                        logger.debug("Doubled value." +
                                "  originalValue=" + originalValue +
                                "  doubledValue=" + doubledValue);
                    } catch (Throwable e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        });

        return bean;
    }

    /**
     * Process after bean initialization.
     */
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.debug("Doubler after initialization of '" + beanName + "' bean.");

        return bean;
    }

}