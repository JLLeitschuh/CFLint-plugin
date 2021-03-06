package org.jenkinsci.plugins.cflint;

import org.jenkinsci.plugins.cflint.Messages;

import hudson.model.AbstractBuild;
import hudson.model.Run;
import hudson.plugins.analysis.core.AbstractResultAction;
import hudson.plugins.analysis.core.HealthDescriptor;
import hudson.plugins.analysis.core.PluginDescriptor;

/**
 * Controls the lifecycle of the Lint results.
 * <p>
 * This action persists the results of the Lint analysis of a build and displays the results on the
 * build page. The actual visualization of the results is defined in the
 * matching <code>summary.jelly</code> file.
 * <p>
 * Moreover, this class renders the Lint result trend.
 * </p>
 */
public class LintResultAction extends AbstractResultAction<LintResult> {

    /**
     * Creates a new instance of {@link LintResultAction}.
     *
     * @param owner Build owning this action.
     * @param healthDescriptor Health descriptor to use.
     * @param result The Lint result for this build.
     */
    public LintResultAction(final AbstractBuild<?, ?> owner,
            final HealthDescriptor healthDescriptor, final LintResult result) {
        super(owner, new LintHealthDescriptor(healthDescriptor), result);
    }
    /**
     * Creates a new instance of {@link LintResultAction}.
     *
     * @param owner Build owning this action.
     * @param healthDescriptor Health descriptor to use.
     * @param result The Lint result for this build.
     */
    public LintResultAction(final Run<?, ?> owner, final HealthDescriptor healthDescriptor, final LintResult result) {
        super(owner, new LintHealthDescriptor(healthDescriptor), result);
    }

    /**
     * Creates a new instance of {@link LintResultAction}.
     *
     * @param owner Build owning this action.
     * @param healthDescriptor Health descriptor to use.
     */
    public LintResultAction(final AbstractBuild<?, ?> owner, final HealthDescriptor healthDescriptor) {
        super(owner, new LintHealthDescriptor(healthDescriptor));
    }

    public String getDisplayName() {
        return Messages.CFLint_DisplayName();
    }

    @Override
    protected PluginDescriptor getDescriptor() {
        return new CFLintDescriptor();
    }

    @Override
    public String getMultipleItemsTooltip(final int numberOfItems) {
        return Messages.CFLint_ResultAction_Tooltip_Multiple(numberOfItems);
    }

    @Override
    public String getSingleItemTooltip() {
        return Messages.CFLint_ResultAction_Tooltip_Single();
    }

}
