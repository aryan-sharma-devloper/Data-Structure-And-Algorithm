class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int[] gain = new int[n];

        for (int i = 0; i < n; i++) {
            gain[i] = 1;

            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    gain[i]++;
                }
            }
        }

        Arrays.sort(items, (a, b) -> Integer.compare(b[1], a[1]));

        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int ans = 0;
        int idx = 0;

        while (idx < n) {
            int price = items[idx][1];

            int[] must = new int[budget + 1];
            Arrays.fill(must, -1);

            while (idx < n && items[idx][1] == price) {
                int g = 1;

                for (int j = 0; j < n; j++) {
                    if (items[j][0] != items[idx][0] ||
                            j != idx) {
                        if (items[j][0] % items[idx][0] == 0) {
                            g++;
                        }
                    }
                }

                for (int c = budget; c >= price; c--) {
                    if (dp[c - price] != -1) {
                        must[c] = Math.max(must[c],
                                dp[c - price] + g);
                    }

                    if (must[c - price] != -1) {
                        must[c] = Math.max(must[c],
                                must[c - price] + g);
                    }

                    if (dp[c - price] != -1) {
                        dp[c] = Math.max(dp[c],
                                dp[c - price] + g);
                    }
                }

                idx++;
            }

            for (int c = 0; c <= budget; c++) {
                if (must[c] != -1) {
                    ans = Math.max(ans,
                            must[c] + (budget - c) / price);
                }
            }
        }

        return ans;
    }
}