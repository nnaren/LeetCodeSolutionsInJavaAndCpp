    
    //   0   1  2    3
    // "This is an example..."
    //  i=0, j=3, width=8, space=(16-8)/(3-0-1)=4, extra=0
    // ------------------------------------------------------
    //   3      4   5        6
    // "example of text justification."
    //  i=3, j=6, width=13, space=(16-13)/(3-0-1)=1, extra=1
    // ------------------------------------------------------
    // "justification."
    //  i=6, j=7, space=1, extra=0
    
    
    public class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> result = new ArrayList<>();
            for (int i = 0, j; i < words.length; ) {
                int width = 0;                                  // width of words without space
                for (j = i; j < words.length && width + words[j].length() + (j - i) <= maxWidth; j++)
                    width += words[j].length();                 /* j is the next word */

                int space = 1, extra = 0;                       // for last line, space=1
                if (j - i != 1 && j != words.length) {          // not 1 word (div-by-zero) and not last line
                    space = (maxWidth - width) / (j - i - 1);   // minus 1 to exclude skip last word
                    extra = (maxWidth - width) % (j - i - 1);
                }

                StringBuilder line = new StringBuilder(words[i]);
                for (i = i + 1; i < j; i++) {                   // move i to j finally
                    for (int s = space; s > 0; s--) line.append(" ");
                    if (extra-- > 0) line.append(" ");
                    line.append(words[i]);
                }
                for (int s = maxWidth - line.length(); s > 0; s--) line.append(" ");
                result.add(line.toString());
            }
            return result;
        }
    }
