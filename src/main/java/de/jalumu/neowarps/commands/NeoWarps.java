package de.jalumu.neowarps.commands;

import de.jalumu.neowarps.util.Transmission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static org.bukkit.ChatColor.*;

public class NeoWarps implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length != 0) {
            switch (args[0]) {
                case "license":
                    new Transmission("NeoWarps\n" +
                            "    Copyright (C) 2020  Jan-Luca Musold\n" +
                            "\n" +
                            "    This program is free software: you can redistribute it and/or modify\n" +
                            "    it under the terms of the GNU General Public License as published by\n" +
                            "    the Free Software Foundation, either version 3 of the License, or\n" +
                            "    (at your option) any later version.\n" +
                            "\n" +
                            "    This program is distributed in the hope that it will be useful,\n" +
                            "    but WITHOUT ANY WARRANTY; without even the implied warranty of\n" +
                            "    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the\n" +
                            "    GNU General Public License for more details.\n" +
                            "\n" +
                            "    You should have received a copy of the GNU General Public License\n" +
                            "    along with this program.  If not, see <https://www.gnu.org/licenses/>.").send(sender);
            }
        } else {

            new Transmission().appendPluginPrefix().appendSpace()
                    .color(GRAY).appendText("NeoWarps programmed with").appendSpace()
                    .color(RED).appendText("❤").appendSpace()
                    .color(GRAY).appendText("and").appendSpace()
                    .color(AQUA).appendText("GitHub").newLine()
                    .color(GRAY).appendText("https://github.com/JaLuMu/NeoWarps").newLine()
                    .color(GRAY).appendText("Metrics can be found on").appendSpace()
                    .color(AQUA).appendText("BStats").newLine()
                    .color(GRAY).appendText("https://bstats.org/plugin/bukkit/NeoWarps").newLine()
                    .color(GRAY).appendText("This Plugin is licensed under the ").appendSpace()
                    .color(AQUA).appendText("GNU GPL v3.0").newLine()
                    .color(GRAY).appendText("Run").appendSpace()
                    .color(AQUA).appendText("/NeoWarps license").appendSpace()
                    .color(GRAY).appendText("for details").send(sender);
        }
        return true;
    }
}
