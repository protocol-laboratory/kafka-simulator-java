package util

import java.util.regex.Pattern

object ValidateUtil {
    private val HOSTNAME_REGEX: Pattern = Pattern.compile("^[a-z\\dA-Z_.\\-]+$")
    private val LIKE_IP_REGEX: Pattern = Pattern.compile("^[\\d.]+$")

    fun isNotHost(host: String): Boolean {
        return !isHost(host)
    }

    fun isHost(host: String): Boolean {
        return if (LIKE_IP_REGEX.matcher(host).matches()) {
            isValidIp(host)
        } else HOSTNAME_REGEX.matcher(host).matches()
    }

    fun isValidIp(ip: String): Boolean {
        return RegexUtil.IPV4_PATTERN.matcher(ip).matches()
    }

    fun isNotPort(port: String): Boolean {
        return !isPort(port)
    }

    fun isPort(port: String): Boolean {
        return try {
            val aux = port.toInt()
            aux > 0 && aux < 65536
        } catch (e: Exception) {
            false
        }
    }

    fun isNotNumber(str: String): Boolean {
        return !isNumber(str)
    }

    fun isNumber(str: String): Boolean {
        return RegexUtil.NUMBER_PATTERN.matcher(str).matches()
    }
}
