package week2;

public class BankReferenceDemo {
    static String normalizeReference(String raw) {
        String ref = raw.trim();
        if (ref.length() >= 3) {
            String bank = ref.substring(0, 3).toUpperCase();
            ref = bank + ref.substring(3);
        }
        return ref;
    }

    static String validateAndFormat(String ref) {
        if (ref.length() != 14) return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(ref.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(ref.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String bank = ref.substring(0, 3);
        String date = ref.substring(3, 9);   // ddMMyy
        String seq = ref.substring(9);       // sequence

        return "[" + bank + "] DATE: " +
                date.substring(0,2) + "/" +
                date.substring(2,4) + "/" +
                date.substring(4,6) +
                " | SEQ: " + seq;
    }

    public static void main(String[] args) {
        String ref1 = normalizeReference(" hdf03022600042 ");
        System.out.println(validateAndFormat(ref1));

        String ref2 = normalizeReference("12F03022600042");
        System.out.println(validateAndFormat(ref2));
    }
}
