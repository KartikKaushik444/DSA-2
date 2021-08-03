package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i])
//where S[i] is the start time of meeting i and F[i] is finish time of meeting i. The task is to
//find the maximum number of meetings that can be accommodated in the meeting room. Print all meeting numbers

// Approach ( greedy same as activity selection)

//Sort all pairs(Meetings) in increasing order of second number(Finish time) of each pair.
//
//Select first meeting of sorted pair as the first Meeting in the room and push it into result vector and
//set a variable time_limet(say) with the second value(Finishing time) of the first selected meeting.
//
//Iterate from the second pair to last pair of the array and if the value of the first
//element(Starting time of meeting) of the current pair is greater then previously selected pair
//finish time (time_limit) then select the current pair and update the result vector 
//(push selected meeting number into vector) and variable time_limit.
//
//Print the Order of meeting from vector.

class Meeting
{
	int start;
	int end;
	int pos;
	Meeting(int start, int end, int pos)
	{
		this.start = start;
		this.end = end;
		this.pos = pos;
	}
}

class meetingComparator implements Comparator<Meeting>
{

	@Override
	public int compare(Meeting o1, Meeting o2) {
//		if(o1.end < o2.end)
//			return -1;
//		else if(o1.end > o2.end)
//			return 1;
//		else if(o1.pos < o2.pos)
//			return -1;
//		return 1;
		return Integer.compare(o1.end, o2.end);
	}
	
	
}

public class NmeetingsInOneRoom {
	
	static void solve(int start[], int end[], int n)
	{
		ArrayList<Meeting> meet = new ArrayList<>();
		
		for(int i=0;i<n;i++)
		{
			meet.add(new Meeting(start[i], end[i], i+1));
		}
		
		meetingComparator mc = new meetingComparator();
		Collections.sort(meet, mc);
		ArrayList<Integer> ans = new ArrayList<>();
		// add first meeting
		ans.add(meet.get(0).pos);
		
		int limit = meet.get(0).end;   // this will point to the finish time of last meeting
		
		for(int i=1;i<n;i++)
		{
			if(meet.get(i).start > limit)
			{
				limit = meet.get(i).end;
				ans.add(meet.get(i).pos);
			}
		}
		
		for(int i=0;i<ans.size();i++)
		{
			System.out.print(ans.get(i) +" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int start[] = {1, 0, 3, 8 ,5, 8};
		int end[] = {2, 6, 4, 2, 7, 9};
		solve(start, end, start.length);
		
		int start1[] = {1, 3, 0, 5,8, 5};
		int end1[] = {2, 4, 6, 7, 9, 9};
		solve(start1, end1, start1.length);
		
		int s[] = {75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924};
		int f[] = {112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252 } ;
		
		solve(s, f, s.length);

	}

}
