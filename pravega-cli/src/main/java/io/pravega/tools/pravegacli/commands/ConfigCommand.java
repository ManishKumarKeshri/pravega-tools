package io.pravega.tools.pravegacli.commands;


/**
 * Base for all Config-related commands.
 */
abstract class ConfigCommand extends AdminCommand {

    static final String COMPONENT = "config";

    ConfigCommand(CommandArgs args) {
        super(args);
    }
}
