/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> allIntervals = new ArrayList();
        List<Interval> freeTime = new ArrayList();

        for(List<Interval> interval : schedule)
            allIntervals.addAll(interval);
        
        Collections.sort(allIntervals, (a,b) -> a.start - b.start);

        Interval last = allIntervals.get(0);

        for(int i = 1; i < allIntervals.size(); i++){

            Interval current = allIntervals.get(i);

            if(current.start > last.end){
                freeTime.add(new Interval(last.end, current.start));
                last = current;
            }
            else{
                last.end = Math.max(last.end, current.end);
            }
        }

        return freeTime;
    }
}