class LongestCommonSubsequence {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        String[][] dp = new String[m + 1][n + 1];
        return helper(str1, str2, 0, 0, dp);
    }
    /** Recursive + Memoization */
    private String helper(String str1, String str2, int m, int n, String[][] dp) {
        // Base case: if one string is exhausted, return the remaining part of the other string
        if (m == str1.length()) return str2.substring(n);
        if (n == str2.length()) return str1.substring(m);

        if(dp[m][n] != null) {
            return dp[m][n];
        }
        if(str1.charAt(m) == str2.charAt(n)) {
            return dp[m][n] = str1.charAt(m) + helper(str1, str2, m + 1, n + 1, dp);
        } else {
            String s1 = str1.charAt(m) + helper(str1, str2, m + 1, n, dp);
            String s2 = str2.charAt(n) + helper(str1, str2, m, n + 1, dp);
            return dp[m][n] = s1.length() > s2.length() ? s2 : s1;
        }
    }
    /** dp **/
    public String shortestCommonSupersequenceDp(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int [][] dp = new int[m + 1][n + 1];

        /** LCS with the help of this i get to common subsequence what is the formula len1 + len2 - lcs = ans **/
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1)); // Match found, include in SCS
                i--; j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1)); // Take from str1
                i--;
            } else {
                sb.append(str2.charAt(j - 1)); // Take from str2
                j--;
            }
        }

        while (i > 0) sb.append(str1.charAt(--i));
        while (j > 0) sb.append(str2.charAt(--j));

        return sb.reverse().toString();
    }

}