package com.example.manawa;

public class User{
        private String email;
        private String fullname;
        private String password;

        public User() {
        }

        public User(String email, String fullname, String password) {
                this.email = email;
                this.fullname = fullname;
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getFullname() {
                return fullname;
        }

        public void setFullname(String fullname) {
                this.fullname = fullname;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }
}
