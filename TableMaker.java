/* Name: Chirath Illukpitiya
 * Email/Netid - cillukpi@u.rochester.edu
 * Assignment: Project 1
 * CSC Lab 171-4 Mon/Wed 12:30 - 1:45
 * Submission date: Feb 10 2022
 */
import java.util.Scanner;
public class TableMaker {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = "";
        String html = "";
        System.out.println("Enter some CSV Data");
        while (s.hasNextLine()) {
            line = s.nextLine();
            if(line.contains("#")) {
                continue;
            }
            if (line.equals("quit")) {
                System.out.println(html);
                break;
            }
            if(line != "") {
                html += "<tr><td>";
            }
            if (line.charAt(0) == ('#')) {
                continue;
            }
            for (int i = 0; (i < line.length()); i++) {
                if (line.charAt(i) == ',') {
                    if (i == 0) {
                        html += ',';
                    }
                    else if ((line.charAt(i - 1) == '\\')) {
                        html += line.charAt(i);
                    }
                    else {
                        html += "</td><td>";
                    }
                }
                else if (line.charAt(i) == '\\') {
                    continue;
                }
                else {
                    html += line.charAt(i);
                }
            }
            html = html.concat("</td></tr>\n");
        }
    }
}

