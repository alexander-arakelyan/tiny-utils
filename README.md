# Tiny Expression Evaluator

Supports expressions like:

1. `1+2` - outputs double
2. `(1+2)` - outputs double
3. `1+2*41` - outputs double
4. `1+2*4-51` - outputs double
5. `1 + 2 * ( 2 - 3) / 41` - outputs double
6. `(1+2+3)*41` - outputs double
7. `10/(1+2*3)*41` - outputs double
8. `2021-11-28T14:50:45 + 1 day` - outputs LocalDateTime
9. `2021-11-28T14:50:45 - 1 day` - outputs LocalDateTime
10. `2021-11-28T14:50:45 unixtime` - outputs LocalDateTime
11. `str1 + str2` - outputs String
12. `str1 + 21` - outputs String
13. `1 + str2` - outputs String

Lookup values are also supported. For example:

```
ExpressionParser.buildDefault()
        .consume("1 + $param1")
        .eval(new ExpressionAlgoContext(o -> {
            if ("param1".equals(o)) {
                return 2;
            }
            return null;
        }));
```
