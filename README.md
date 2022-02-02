```bash
curl -v localhost:9999/superheroes/1
```

will print: 

```json
{"name":"Peter - Parker - alias Spiderman"}{"error":{"code":"FAILURE","message":"Does not compute"}}
```

Which is not valid json, this stack trace is:

```
Caused by: org.springframework.beans.NotReadablePropertyException: Invalid property 'test' of bean class [io.nbaars.superheroes.domain.SuperHero]: Could not find field for property during fallback access!
	at org.springframework.data.util.DirectFieldAccessFallbackBeanWrapper.getPropertyValue(DirectFieldAccessFallbackBeanWrapper.java:58) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.projection.PropertyAccessingMethodInterceptor.invoke(PropertyAccessingMethodInterceptor.java:73) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.projection.SpelEvaluatingMethodInterceptor.invoke(SpelEvaluatingMethodInterceptor.java:138) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.projection.ProjectingMethodInterceptor.invoke(ProjectingMethodInterceptor.java:76) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.data.projection.ProxyProjectionFactory$TargetAwareMethodInterceptor.invoke(ProxyProjectionFactory.java:253) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:80) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215) ~[spring-aop-5.3.15.jar:5.3.15]
	at jdk.proxy2/jdk.proxy2.$Proxy114.getTest(Unknown Source) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at com.fasterxml.jackson.databind.ser.BeanPropertyWriter.serializeAsField(BeanPropertyWriter.java:689) ~[jackson-databind-2.13.1.jar:2.13.1]
	at com.fasterxml.jackson.databind.ser.std.BeanSerializerBase.serializeFields(BeanSerializerBase.java:774) ~[jackson-databind-2.13.1.jar:2.13.1]
```

Without the SpEL expression, the response is:

```json
{"error":{"code":"FAILURE","message":"Does not compute"}}
```

The stacktrace has a different origin:

```
org.springframework.data.mapping.PropertyReferenceException: No property name found for type SuperHero!
	at org.springframework.data.mapping.PropertyPath.<init>(PropertyPath.java:90) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.mapping.PropertyPath.create(PropertyPath.java:437) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.mapping.PropertyPath.create(PropertyPath.java:413) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.mapping.PropertyPath.lambda$from$0(PropertyPath.java:366) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at java.base/java.util.concurrent.ConcurrentMap.computeIfAbsent(ConcurrentMap.java:330) ~[na:na]
	at org.springframework.data.mapping.PropertyPath.from(PropertyPath.java:348) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.mapping.PropertyPath.from(PropertyPath.java:331) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.JpaQueryCreator.complete(JpaQueryCreator.java:175) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.JpaQueryCreator.complete(JpaQueryCreator.java:152) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.JpaQueryCreator.complete(JpaQueryCreator.java:59) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.repository.query.parser.AbstractQueryCreator.createQuery(AbstractQueryCreator.java:95) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.PartTreeJpaQuery$QueryPreparer.createQuery(PartTreeJpaQuery.java:232) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.PartTreeJpaQuery.doCreateQuery(PartTreeJpaQuery.java:106) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.AbstractJpaQuery.createQuery(AbstractJpaQuery.java:227) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.JpaQueryExecution$SingleEntityExecution.doExecute(JpaQueryExecution.java:198) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.JpaQueryExecution.execute(JpaQueryExecution.java:90) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.AbstractJpaQuery.doExecute(AbstractJpaQuery.java:155) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.jpa.repository.query.AbstractJpaQuery.execute(AbstractJpaQuery.java:143) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:137) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:121) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:159) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:138) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:80) ~[spring-data-commons-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123) ~[spring-tx-5.3.15.jar:5.3.15]
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:388) ~[spring-tx-5.3.15.jar:5.3.15]
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119) ~[spring-tx-5.3.15.jar:5.3.15]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:137) ~[spring-tx-5.3.15.jar:5.3.15]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:145) ~[spring-data-jpa-2.6.1.jar:2.6.1]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186) ~[spring-aop-5.3.15.jar:5.3.15]
	at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:215) ~[spring-aop-5.3.15.jar:5.3.15]
	at jdk.proxy2/jdk.proxy2.$Proxy97.findById(Unknown Source) ~[na:na]
	at io.nbaars.superheroes.controller.SuperHeroController.getSuperHeroById(SuperHeroController.java:27) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205) ~[spring-web-5.3.15.jar:5.3.15]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150) ~[spring-web-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:117) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:895) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1067) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:963) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.15.jar:5.3.15]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898) ~[spring-webmvc-5.3.15.jar:5.3.15]
```