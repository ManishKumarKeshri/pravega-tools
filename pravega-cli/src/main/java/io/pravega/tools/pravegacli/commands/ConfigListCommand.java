package io.pravega.tools.pravegacli.commands;

import com.google.common.base.Preconditions;
import io.pravega.tools.pravegacli.commands.CommandArgs;

/**
 * Lists the contents of the shared Configuration.
 */
public class ConfigListCommand extends ConfigCommand {
    /**
     * Creates a new instance of the Command class.
     *
     * @param args The arguments for the command.
     */
    public ConfigListCommand(CommandArgs args) {
        super(args);
    }

    @Override
    public void execute() {
        Preconditions.checkArgument(getCommandArgs().getArgs().size() == 0, "Not expecting any arguments.");
        getCommandArgs().getState().getConfigBuilder().build().forEach((name, value) -> output("\t%s=%s", name, value));
    }

    public static CommandDescriptor descriptor() {
        return new CommandDescriptor(COMPONENT, "list", "Lists all configuration set during this session.");
    }
}
