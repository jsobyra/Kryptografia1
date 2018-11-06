import com.lambdaworks.crypto.SCryptUtil;
import de.rtner.security.auth.spi.SimplePBKDF2;
import org.apache.commons.codec.digest.DigestUtils;
import org.mindrot.jbcrypt.BCrypt;

public class Hasher {

    public static String sha256Hash(String text) {
        return DigestUtils.sha256Hex(text);
    }

    public static String sha512Hash(String text) {
        return DigestUtils.sha512Hex(text);
    }

    public static String bcryptHash(String text) {
        return BCrypt.hashpw(text, BCrypt.gensalt());
    }

    public static String scryptHash(String text) {
        return SCryptUtil.scrypt(text, 16384, 8, 1);
    }

    public static String pbkdf2Hash(String text) {
        return new SimplePBKDF2().deriveKeyFormatted(text);
    }
}
