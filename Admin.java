// Rithvik
public class Admin {
    private String username;
    private String password;
    private boolean signedIn;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        this.signedIn = false;
    }

    public boolean authenticate(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.signedIn = true;
            return true;
        }
        return false;
    }

    public void signOut() {
        this.signedIn = false;
    }

    public boolean isSignedIn() {
        return signedIn;
    }

    public boolean verifyTutor(Tutor t) {
        if (!signedIn) {
            return false;
        }
        t.setVerify(true);
        return true;
    }

    public boolean unverifyTutor(Tutor t) {
        if (!signedIn) {
            return false;
        }
        t.setVerify(false);
        return true;
    }
}
