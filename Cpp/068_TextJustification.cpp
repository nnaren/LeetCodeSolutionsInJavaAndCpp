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
class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) {
        vector<string> res;
        
        for (int i = 0, j; i < words.size(); ) {
            int width = 0;  // width of words without space  
            for (j = i; j < words.size() && width + words[j].length() + (j - i) <= L; j++) 
                width += words[j].length(); /* j is the next word */
            
            int space = 1, extra = 0;    // for last line, space=1
            if (j - i != 1 && j != words.size()) { // not 1 word (div-by-zero) and not last line
                space = (L - width) / (j - i - 1); // minus 1 to exclude skip last word
                extra = (L - width) % (j - i - 1);
            }
            
            string line(words[i]);
            for (i = i + 1; i < j; i++) { // move i to j finally
                line.append(string(space, ' '));
                if (extra-- > 0) line.append(" ");
                line.append(words[i]);
            }
            for (int s = L - line.length(); s > 0; s--)
                line.append(" ");
            res.push_back(line);
        }
        return res;
    } 
};
