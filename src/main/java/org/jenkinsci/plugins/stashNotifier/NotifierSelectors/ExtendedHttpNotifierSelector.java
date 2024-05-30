package org.jenkinsci.plugins.stashNotifier.NotifierSelectors;

import edu.umd.cs.findbugs.annotations.NonNull;
import org.jenkinsci.plugins.stashNotifier.Notifiers.DefaultApacheHttpNotifier;
import org.jenkinsci.plugins.stashNotifier.Notifiers.ExtendedApacheHttpNotifier;
import org.jenkinsci.plugins.stashNotifier.Notifiers.HttpNotifier;
import org.jenkinsci.plugins.stashNotifier.SelectionContext;

import java.util.List;

public class ExtendedHttpNotifierSelector implements HttpNotifierSelector {
    private final List<HttpNotifier> httpNotifiers;

    public ExtendedHttpNotifierSelector(List<HttpNotifier> notifiers) {
        httpNotifiers = notifiers;
    }

    @Override
    public HttpNotifier select(@NonNull SelectionContext context) {
        if(context.getBitBucketProjectKey().isEmpty() || context.getBitBucketProjectSlug().isEmpty())
        {
            return httpNotifiers.stream().filter(hn -> hn.getClass().getName().equals(DefaultApacheHttpNotifier.class.getName())).findFirst().get();
        }
        return httpNotifiers.stream().filter(hn -> hn.getClass().getName().equals(ExtendedApacheHttpNotifier.class.getName())).findFirst().get();
    }
}
