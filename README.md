# pinpoint-es-plugin



Here is the elastic-search plugin for pinpoint platform.

build with es 1.7.2, and intercept method:

```java
@TargetConstructor({"org.elasticsearch.common.settings.Settings" }) //for cluster name 
```



```java

@TargetMethods({
        @TargetMethod(name = "doExecute", paramTypes = "org.elasticsearch.action.ActionListener") //for api invocation
})
```

