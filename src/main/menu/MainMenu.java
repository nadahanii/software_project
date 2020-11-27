/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class MainMenu {

    static interface messageparameter {

        public String getpar();

    }

    static public class sms implements messageparameter {

        public String phone;

        public void setphone(String p) {
            phone = p;
        }

        @Override
        public String getpar() {
            return phone;
        }
    }

    static public class email implements messageparameter {

        public String email;

        public void setemail(String t) {
            email = t;
        }

        @Override
        public String getpar() {
            return email;
        }
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }
        return null;
    }

    class notification_template {

        ArrayList<Map<String, String>> temp = new ArrayList<>();
        public String Lastmsgtemp = "";

        public void create_message_template(String t, String language, boolean again) {
            if (again) {
                temp.get(temp.size() - 1).put(language, t);
            } else {
                Map<String, String> tempMap = new HashMap<>();
                tempMap.put(language, t);
                temp.add(temp.size(), tempMap);
            }
            Lastmsgtemp = t;
        }

        public void update_message_template(String old, String neww) {

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).containsValue(old)) {
                    String k = getKey(temp.get(i), old);
                    temp.get(i).replace(k, neww);

                }

            }
        }

        public void delete_message_template(String t) {

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).containsValue(t)) {
                    String k = getKey(temp.get(i), t);
                    temp.get(i).remove(k);
                }
            }
        }

        public void read_message_template() {
            for (int i = 0; i < temp.size(); i++) {
                System.out.println(temp.get(i));
            }
        }

    }

    interface notifications {

        public void message(messageparameter k);

    }

    static public class confirmation_notification extends notification_template implements notifications {

        /**
         *
         * @param k
         */
        @Override
        public void message(messageparameter k) {//{p}
            //k=01112154684
            for (int i = 0; i < Lastmsgtemp.length(); i++) {
                if (Lastmsgtemp.charAt(i) == '{' && Lastmsgtemp.charAt(i + 1) == 'p' && Lastmsgtemp.charAt(i + 2) == '}') {
                    System.out.print(k.getpar());
                    i += 3;
                } else {
                    System.out.print(Lastmsgtemp.charAt(i));
                }
            }
            System.out.println();
        }
    }

    public static class registration_notification extends notification_template implements notifications {

        /**
         *
         * @param k
         */
        @Override
        public void message(messageparameter k) {//{e}
            for (int i = 0; i < Lastmsgtemp.length(); i++) {
                if (Lastmsgtemp.charAt(i) == '{' && Lastmsgtemp.charAt(i + 1) == 'e' && Lastmsgtemp.charAt(i + 2) == '}') {
                    System.out.print(k.getpar());
                    i += 3;
                } else {
                    System.out.print(Lastmsgtemp.charAt(i));
                }
            }
            System.out.println();
        }
    }

    public static class reset_pass extends notification_template implements notifications {

        /**
         *
         * @param k
         */
        @Override
        public void message(messageparameter k) {//{e}
            for (int i = 0; i < Lastmsgtemp.length(); i++) {
                if (Lastmsgtemp.charAt(i) == '{' && Lastmsgtemp.charAt(i + 1) == 'e' && Lastmsgtemp.charAt(i + 2) == '}') {
                    System.out.print(k.getpar());
                    i += 3;
                } else {
                    System.out.print(Lastmsgtemp.charAt(i));
                }
            }
            System.out.println();
        }
    }

    /**
     */
    public static class User {

        public String name;
        public String phone;
        public String email;

        public void setname(String n) {
            name = n;
        }

        public void setphonee(String p) {
            phone = p;
        }

        public void setemaill(String e) {
            email = e;
        }

        public String getname() {
            return name;
        }

        public String getphonee() {
            return phone;
        }

        public String getemaill() {
            return email;
        }
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setemaill("mohamedahmed@gmail.com");
        user1.setname("mohamed");
        user1.setphonee("0112346598");
        users.add(user1);
        User user2 = new User();
        user2.setemaill("monazaky32@gmail.com");
        user2.setname("mona");
        user2.setphonee("0112583697");
        users.add(user2);
        User user3 = new User();
        user3.setemaill("farida_osama138@gmail.com");
        user3.setname("farida");
        user3.setphonee("0112888893");
        users.add(user3);
        reset_pass obj1 = new reset_pass();
        registration_notification obj2 = new registration_notification();
        confirmation_notification obj3 = new confirmation_notification();
        sms smss = new sms();
        email emaill = new email();

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("choose 1 if you want to add template or 2 if you want to send notification");
            int main_choice = input.nextInt();

            if (main_choice == 1) {
                System.out.println("Choose your notification:\n 1-Reset Password \n 2-Registration \n 3-Confirmation");
                int choice;
                choice = input.nextInt();
                input.nextLine();
                int choice2;

                String str, lang;
                if (choice == 1) {

                    System.out.println("Choose your Operation:\n 1-Create \n 2-Delete \n 3-Read \n 4-Update");
                    choice2 = input.nextInt();
                    input.nextLine();
                    if (choice2 == 1) {
                        System.out.println("enter your template");
                        str = input.nextLine();

                        System.out.println("enter the language");
                        lang = input.nextLine();

                        obj1.create_message_template(str, lang, false);
                        while (true) {
                            System.out.println("want to add another language of this temp?");
                            String add = input.nextLine();

                            if (add.equalsIgnoreCase("no")) {
                                break;
                            } else {
                                System.out.println("enter your template");
                                str = input.nextLine();

                                System.out.println("enter the language");
                                lang = input.nextLine();

                                obj1.create_message_template(str, lang, true);
                            }
                        }

                    } else if (choice2 == 2) {
                        System.out.println("enter the template you want to delete it");
                        str = input.nextLine();
                        obj1.delete_message_template(str);
                    } else if (choice2 == 3) {
                        obj1.read_message_template();
                    } else if (choice2 == 4) {
                        System.out.println("enter the old template");
                        str = input.nextLine();
                        System.out.println("enter the new template");
                        String neww = input.nextLine();
                        obj1.update_message_template(str, neww);
                    } else {
                        System.out.println("Invalid Option");
                    }

                } else if (choice == 2) {

                    System.out.println("Choose your Operation:\n 1-Create \n 2-Delete \n 3-Read \n 4-Update");
                    choice2 = input.nextInt();
                    input.nextLine();
                    if (choice2 == 1) {
                        System.out.println("enter your template");
                        str = input.nextLine();

                        System.out.println("enter the language");
                        lang = input.nextLine();

                        obj1.create_message_template(str, lang, false);
                        while (true) {
                            System.out.println("want to add another language of this temp?");
                            String add = input.nextLine();

                            if (add.equalsIgnoreCase("no")) {
                                break;
                            } else {
                                System.out.println("enter your template");
                                str = input.nextLine();

                                System.out.println("enter the language");
                                lang = input.nextLine();

                                obj1.create_message_template(str, lang, true);
                            }
                        }

                    } else if (choice2 == 2) {
                        System.out.println("enter the template you want to delete it");
                        str = input.nextLine();
                        // obj2.delete_message_template(str);
                    } else if (choice2 == 3) {
                        obj2.read_message_template();
                    } else if (choice2 == 4) {
                        System.out.println("enter the old template");
                        str = input.nextLine();
                        System.out.println("enter the new template");
                        String neww = input.nextLine();
                        //  obj2.update_message_template(str, neww);
                    } else {
                        System.out.println("Invalid Option");
                    }
                } else if (choice == 3) {

                    System.out.println("Choose your Operation:\n 1-Create \n 2-Delete \n 3-Read \n 4-Update");
                    choice2 = input.nextInt();
                    input.nextLine();
                    if (choice2 == 1) {
                        System.out.println("enter your template");
                        str = input.nextLine();

                        System.out.println("enter the language");
                        lang = input.nextLine();

                        obj1.create_message_template(str, lang, false);
                        while (true) {
                            System.out.println("want to add another language of this temp?");
                            String add = input.nextLine();

                            if (add.equalsIgnoreCase("no")) {
                                break;
                            } else {
                                System.out.println("enter your template");
                                str = input.nextLine();

                                System.out.println("enter the language");
                                lang = input.nextLine();

                                obj1.create_message_template(str, lang, true);
                            }
                        }
                    } else if (choice2 == 2) {
                        System.out.println("enter the template you want to delete it");
                        str = input.nextLine();
                        //  obj3.delete_message_template(str);
                    } else if (choice2 == 3) {
                        obj3.read_message_template();
                    } else if (choice2 == 4) {
                        System.out.println("enter the old template");
                        str = input.nextLine();
                        System.out.println("enter the new template");
                        String neww = input.nextLine();
                        //   obj3.update_message_template(str, neww);
                    } else {
                        System.out.println("Invalid Option");
                    }
                } else {
                    System.out.println("Invalid option ");

                }
            } else if (main_choice == 2) {
                System.out.println("send 1- registration notification by email 2-reset_pass by email 3-phone notification by phone");
                int noti_choice = input.nextInt();
                if (noti_choice == 1 || noti_choice == 2) {
                    System.out.println("enter the name of person");
                    String name = input.next();
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).name.equalsIgnoreCase(name)) {
                            emaill.setemail(users.get(i).email);
                            break;
                        }
                    }
                    if (noti_choice == 1) {
                        obj2.message(emaill);
                    } else {
                        obj1.message(emaill);
                    }
                } else if (noti_choice == 3) {
                    System.out.println("enter the name of person");
                    String name = input.next();
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).name.equalsIgnoreCase(name)) {
                            smss.setphone(users.get(i).phone);
                            break;
                        }
                    }
                    obj3.message(smss);
                } else {
                    System.out.println("invalid choice");
                }
            }

            System.out.println("another option? ");
            String op;
            op = input.next();
            if (op.equalsIgnoreCase("no")) {
                break;
            }

        }
    }
    
}
