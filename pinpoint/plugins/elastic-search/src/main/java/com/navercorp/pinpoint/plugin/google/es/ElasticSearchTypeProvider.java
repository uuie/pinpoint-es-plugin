package com.navercorp.pinpoint.plugin.google.es;

import com.navercorp.pinpoint.common.trace.TraceMetadataProvider;
import com.navercorp.pinpoint.common.trace.TraceMetadataSetupContext;

/**
 * 
 * @author chris
 *
 */
public class ElasticSearchTypeProvider implements TraceMetadataProvider {

    @Override
    public void setup(TraceMetadataSetupContext context) {
        context.addServiceType(ElasticSearchClientConstants.ES_CLIENT_INTERNAL);
    }
}
