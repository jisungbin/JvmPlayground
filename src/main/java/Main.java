import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Run Configuration used for running Android Apps (and Instant Apps) locally on a device/emulator.
 */
public class AndroidRunConfiguration extends AndroidRunConfigurationBase implements RefactoringListenerProvider, RunnerIconProvider, AppRunConfiguration {
    // ...

    public String ACTIVITY_EXTRA_FLAGS = "";

    @Nullable
    @Override
    protected AppLaunchTask getApplicationLaunchTask(@NotNull ApplicationIdProvider applicationIdProvider,
                                                     @NotNull AndroidFacet facet,
                                                     @NotNull String contributorsAmStartOptions,
                                                     boolean waitForDebugger,
                                                     @NotNull LaunchStatus launchStatus,
                                                     @NotNull ApkProvider apkProvider,
                                                     @NotNull ConsolePrinter consolePrinter,
                                                     @NotNull IDevice device) {
        ActivityLaunchOptionState state = getLaunchOptionState(MODE);
        assert state != null;

        String extraFlags = ACTIVITY_EXTRA_FLAGS;
        if (!contributorsAmStartOptions.isEmpty()) {
            extraFlags += (extraFlags.isEmpty() ? "" : " ") + contributorsAmStartOptions;
        }

        if (device.getVersion().isGreaterOrEqualThan(AndroidVersion.VersionCodes.TIRAMISU)) {
            extraFlags += (extraFlags.isEmpty() ? "" : " ") + "--splashscreen-show-icon";
        }

        StartActivityFlagsProvider startActivityFlagsProvider;
        if (facet.getConfiguration().getProjectType() == PROJECT_TYPE_INSTANTAPP) {
            startActivityFlagsProvider = new InstantAppStartActivityFlagsProvider();
        } else {
            startActivityFlagsProvider = new DefaultStartActivityFlagsProvider(waitForDebugger, extraFlags);
        }

        try {
            return state.getLaunchTask(applicationIdProvider.getPackageName(), facet, startActivityFlagsProvider, getProfilerState(), apkProvider);
        } catch (ApkProvisionException e) {
            Logger.getInstance(AndroidRunConfiguration.class).error(e);
            launchStatus.terminateLaunch("Unable to identify application id", true);
            return null;
        }
    }
}