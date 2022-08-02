package com.tianyu.springcloudcontractdemoprovider.core;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ClassPathControllerScanningUtil extends ClassPathScanningCandidateComponentProvider {
    private static ClassPathControllerScanningUtil instance =  new ClassPathControllerScanningUtil();
    private ClassPathControllerScanningUtil(){
        super();
        super.resetFilters(false);
        super.addIncludeFilter(new AnnotationTypeFilter(Controller.class));
        super.addIncludeFilter(new AnnotationTypeFilter(RestController.class));
    }

    public static ClassPathControllerScanningUtil getInstance(){
        return instance;
    }

    public Object[] scan(String controllerBasePackage){
        Optional<Set<Object>> objs = doScan(controllerBasePackage);
        return objs.map(o -> o.toArray()).orElse(new Object[]{});
    }

    private Optional<Set<Object>> doScan(String controllerBasePackage){
        Set<BeanDefinition> beanDefinitions = this.findCandidateComponents(controllerBasePackage);
        Set<Object> scannedClazzs = beanDefinitions.stream().map(bean -> {
            try {
                return Class.forName(bean.getBeanClassName()).newInstance();
            }catch(Exception e){
                return null;
            }
        }).filter(o -> o != null).collect(Collectors.toSet());
        return Optional.ofNullable(scannedClazzs);
    }
}
