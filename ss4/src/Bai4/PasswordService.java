package Bai4;

public class PasswordService {

    public String evaluatePasswordStrength(String password) {

        if (password.length() < 3) {
            return "Yếu";
        }

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasNumber = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");

        if (password.length() >= 8 && hasUpper && hasLower && hasNumber && hasSpecial) {
            return "Mạnh";
        }

        if (password.length() >= 6) {
            return "Trung bình";
        }

        return "Yếu";
    }
}
