package medium;

import java.util.*;

public class Q721AccountsMerge_Review {
    class UnionFind {
        int[] parents;

        UnionFind(int size) {
            parents = new int[size];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        int find(int node) {
            while (parents[node] != node)
                node = parents[node];

            return node;
        }

        void union(int firstNode, int secondNode) {
            int firstParent = find(firstNode);
            int secondParent = find(secondNode);

            if (firstParent == secondParent)
                return;

            parents[firstParent] = secondParent;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        /**
         * Union Find
         * since the problem describes a connection between an account and emails
         * and we want to merge the accounts, this seems like a good candidate for union
         * find.
         *
         * The issue becomes how to transfer the email to an integer to be used in union
         * find. Actually, we need to use the accounts instead of emails since the merge will happen on the
         * account level not the email level.
         *
         * To do so, each account will get an account id equal to its index in accounts array
         *
         * Now, we need to loop through all emails, mapping them to account id,
         * if we find an email that we have seen before, we union the two account ids
         *
         * Now since we have unioned the account, we need to loop through the account again
         * and merge the emails into the final parent account of all merged accounts
         * here we can add the emails to TreeSet to be sorted on the fly
         *
         * Finally we need to create the final result list, adding the account owner name to
         * the beginning of the list
         */
        Map<String, Integer> emailToAccount = new HashMap<>();
        UnionFind unionFind = new UnionFind(accounts.size());

        // mapping emails to account, if an email has been seen before, union the two
        // accounts together
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            int accountId = i;
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email)) {
                    // if we have seen an email before in a different account, we union these two
                    // accounts
                    int previousAccount = emailToAccount.get(email);
                    unionFind.union(accountId, previousAccount);
                    continue;
                } else {
                    emailToAccount.put(email, accountId);
                }
            }
        }

        // map each account to its emails after merging, sort the emails while doing so
        Map<Integer, TreeSet<String>> accountEmails = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            int accountId = i;
            int accountParent = unionFind.find(accountId);
            List<String> emails = accounts.get(accountId).subList(1, accounts.get(accountId).size());
            if (accountEmails.containsKey(accountParent)) {
                accountEmails.get(accountParent).addAll(emails);
            } else {
                TreeSet<String> sortedEmails = new TreeSet<>();
                sortedEmails.addAll(emails);
                accountEmails.put(accountParent, sortedEmails);
            }
        }

        // create the final result list
        List<List<String>> result = new ArrayList<>();
        for (int accountId : accountEmails.keySet()) {
            List<String> sortedAccountEmails = new ArrayList<>();
            sortedAccountEmails.add(accounts.get(accountId).get(0));
            sortedAccountEmails.addAll(accountEmails.get(accountId));
            result.add(sortedAccountEmails);
        }

        return result;
    }
}
