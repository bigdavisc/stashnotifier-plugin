package org.jenkinsci.plugins.stashNotifier.NotifierSelectors;

import edu.umd.cs.findbugs.annotations.NonNull;
import org.jenkinsci.plugins.stashNotifier.Notifiers.DefaultApacheHttpNotifier;
import org.jenkinsci.plugins.stashNotifier.Notifiers.HttpNotifier;
import org.jenkinsci.plugins.stashNotifier.SelectionContext;

/**
 * This is the default way of selecting a {@link HttpNotifier}.
 * Always returns {@link DefaultApacheHttpNotifier} for backwards compatibility with v1.20 and earlier.
 */
public class DefaultHttpNotifierSelector implements HttpNotifierSelector {
    private final HttpNotifier httpNotifier;

    public DefaultHttpNotifierSelector(HttpNotifier httpNotifier) {
        this.httpNotifier = httpNotifier;
    }

    /**
     * @param context unused
     * @return singleton {@link DefaultApacheHttpNotifier}
     */
    @Override
    public HttpNotifier select(@NonNull SelectionContext context) {
        return httpNotifier;
    }
}
