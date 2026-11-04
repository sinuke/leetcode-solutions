# add-solution

Select the solution type:

- [Java](add-solution-java.md) — for LeetCode Java problems
- [SQL](add-solution-sql.md) — for LeetCode SQL problems
- [JS](add-solution-js.md) — for LeetCode JavaScript problems
- [Pandas](add-solution-pandas.md) — for LeetCode Pandas problems
- [Shell](add-solution-shell.md) — for LeetCode Shell problems

Each command takes only the LeetCode problem link — level, number, and title are fetched from LeetCode's GraphQL endpoint (`https://leetcode.com/graphql`) with `curl`, not asked for or guessed. Title is always taken from the fetched data, never derived from the URL.
