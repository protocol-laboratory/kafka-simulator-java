package util

import java.util.regex.Pattern

object RegexUtil {

    private const val NUMBER_REG = "[0-9]+"

    private const val WORDS_REG = "\\w+"

    private const val IPV4_REGEX = "\\A(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}\\z"

    val NUMBER_PATTERN: Pattern = Pattern.compile(NUMBER_REG)

    val WORDS_PATTERN: Pattern = Pattern.compile(WORDS_REG)

    val IPV4_PATTERN: Pattern = Pattern.compile(IPV4_REGEX)
}
