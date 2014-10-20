/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals == null || intervals.size() ==0)
            return res;
        Stack<Interval> st = new Stack<Interval>();
        for(Interval interval : intervals)
        {
            st.push(interval);
        }
        while(!st.isEmpty())
        {
            boolean isMerged = false;
            Interval base = st.pop();
            Stack<Interval> cop = new Stack<Interval>();
            while(!st.isEmpty())
            {
                Interval cur = st.pop();
                if((cur.end<=base.end && cur.end>=base.start) || (base.end >= cur.start&& base.end<=cur.end))
                {
                    isMerged = true;
                    base = merge(cur, base);
                }
                else
                {
                    cop.push(cur);
                }
            }
            if(isMerged)
                st.push(base);
            else
                res.add(base);
            while(!cop.isEmpty())
            {
                st.push(cop.pop());
            }
        }
        return res;
    }
    
    
    public Interval merge(Interval a, Interval b)
    {
        int s = a.start>b.start?b.start:a.start;
        int e = a.end>b.end? a.end: b.end;
        return new Interval(s, e);
    }
}
