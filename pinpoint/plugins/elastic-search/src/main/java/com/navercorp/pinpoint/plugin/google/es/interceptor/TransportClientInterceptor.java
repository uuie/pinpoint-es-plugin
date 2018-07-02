package com.navercorp.pinpoint.plugin.google.es.interceptor;

import com.navercorp.pinpoint.bootstrap.context.*;
import com.navercorp.pinpoint.bootstrap.interceptor.SpanEventSimpleAroundInterceptorForPlugin;
import com.navercorp.pinpoint.bootstrap.interceptor.annotation.TargetConstructor;
import com.navercorp.pinpoint.bootstrap.plugin.jdbc.DatabaseInfoAccessor;
import com.navercorp.pinpoint.bootstrap.util.InterceptorUtils;
import com.navercorp.pinpoint.plugin.google.es.ElasticSearchClientConstants;

/**
 * Created by chris on 6/29/16.
 */

@TargetConstructor({"org.elasticsearch.common.settings.Settings" })
public class TransportClientInterceptor extends SpanEventSimpleAroundInterceptorForPlugin {

    public TransportClientInterceptor(TraceContext traceContext, MethodDescriptor descriptor) {
        super(traceContext, descriptor);
    }

    @Override
    protected void doInBeforeTrace(SpanEventRecorder recorder, Object target, Object[] args) {

    }

    @Override
    protected void doInAfterTrace(SpanEventRecorder recorder, Object target, Object[] args, Object result, Throwable throwable) {

        if(args.length!=1 || !(args[0] instanceof org.elasticsearch.common.settings.Settings))
            return;
        org.elasticsearch.common.settings.Settings settings=(org.elasticsearch.common.settings.Settings)args[0];
        String clusterName=settings.get("cluster.name","unknown");
        recorder.recordServiceType(ElasticSearchClientConstants.ES_CLIENT_INTERNAL);
        recorder.recordDestinationId(clusterName);
    }
}
