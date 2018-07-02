
package com.navercorp.pinpoint.plugin.google.es.interceptor;

import com.navercorp.pinpoint.bootstrap.context.MethodDescriptor;
import com.navercorp.pinpoint.bootstrap.context.SpanEventRecorder;
import com.navercorp.pinpoint.bootstrap.context.Trace;
import com.navercorp.pinpoint.bootstrap.context.TraceContext;
import com.navercorp.pinpoint.bootstrap.interceptor.SpanEventSimpleAroundInterceptorForPlugin;
import com.navercorp.pinpoint.bootstrap.interceptor.annotation.Scope;
import com.navercorp.pinpoint.bootstrap.interceptor.annotation.TargetMethod;
import com.navercorp.pinpoint.bootstrap.interceptor.annotation.TargetMethods;
import com.navercorp.pinpoint.plugin.google.es.ElasticSearchClientConstants;

/**
 * 
 * @author chris
 *
 */
@Scope(value = ElasticSearchClientConstants.ES_SCOPE)
@TargetMethods({
        @TargetMethod(name = "doExecute", paramTypes = "org.elasticsearch.action.ActionListener")
})
public class SearchRequestBuilderInterceptor extends SpanEventSimpleAroundInterceptorForPlugin {

    public SearchRequestBuilderInterceptor(TraceContext traceContext, MethodDescriptor descriptor) {
        super(traceContext, descriptor);
    }

    @Override
    protected void doInBeforeTrace(SpanEventRecorder recorder, Object target, Object[] args) {
    }

    @Override
    protected void doInAfterTrace(SpanEventRecorder recorder, Object target, Object[] args, Object result, Throwable throwable) {
        recorder.recordApi(methodDescriptor);
        recorder.recordServiceType(ElasticSearchClientConstants.ES_CLIENT_INTERNAL);
        recorder.recordException(throwable);

    }
}
