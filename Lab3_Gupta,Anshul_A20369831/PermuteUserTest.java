import static org.junit.Assert.*;

import org.junit.Test;

public class PermuteUserTest {

	@Test
	public void test1() {
		StringBuilder sb1 = new StringBuilder("abc\nacb\nbac\nbca\ncba\ncab\n");
		StringBuilder sb2 = new StringBuilder("abc");
		assertEquals(sb1.toString(), PermuteUser.permute(sb2).toString());
		
	}
	
	public void test2() {
		StringBuilder sb3 = new StringBuilder("abbc\nabcb\nabbc\nabcb\nacbb\nacbb\nbabc\nbacb\nbbac\nbbca\nbcba\nbcab\nbbac\nbbca\nbabc\nbacb\nbcab\nbcba\ncbba\ncbab\ncbba\ncbab\ncabb\ncabb\n");
		StringBuilder sb4 = new StringBuilder("abbc");
		assertEquals(sb3.toString(), PermuteUser.permute(sb4).toString());
		
	}
	
	public void test3() {
		StringBuilder sb5 = new StringBuilder("1234\n1243\n1324\n1342\n1432\n1423\n2134\n2143\n2314\n2341\n2431\n2413\n3214\n3241\n3124\n3142\n3412\n3421\n4231\n4213\n4321\n4312\n4132\n4123\n");
		StringBuilder sb6 = new StringBuilder("1234");
		assertEquals(sb5.toString(), PermuteUser.permute(sb6).toString());
		
	}
	
	public void test4() {
		StringBuilder sb7 = new StringBuilder("wzxy\nwzyx\nwxzy\nwxyz\nwyzx\nwyxz\nzwxy\nzwyx\nzxwy\nzxyw\nzywx\nzyxw\nxwzy\nxwyz\nxzwy\nxzyw\nxywz\nxyzw\nywzx\nywxz\nyzwx\nyzxw\nyxwz\nyxzw\n");
		StringBuilder sb8 = new StringBuilder("wzxy");
		assertEquals(sb7.toString(), PermuteUser.permute(sb8).toString());
		
	}

}

