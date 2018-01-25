# uuid-shootout
Java UUID Parsing Performance Comparison

# Parsers
* Real
  * BigInteger
  * Long.parseUnsignedLong
  * Regex
  * Compiled Regex
  * String Concat
  * String Builder
  * Bit Shift
* Fake
  * Fully Random
  * Fully Static
* Slow
  * String Splitter
  * String Multi Concat

# Results
| Parser              | Runtime  |
|---------------------|----------|
| String Splitter     | 10411 ms |
| Fully Random	      | 1668 ms  |
| Regex	              | 2366 ms  |
| Compiled Regex      | 1355 ms  |
| String Multi Concat | 846 ms   |
| String Builder      | 745 ms   |
| String Concat	      | 722 ms   |
| BigInteger 1        | 570 ms   |
| BigInteger 2        | 531 ms   |
| Long                | 393 ms   |
| Bit Shift           | 270 ms   |
| Fully Static        | 56 ms    |
| JDK                 | 813 ms   |
