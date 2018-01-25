package wlg.word;

import java.util.List;

import org.ansj.app.keyword.KeyWordComputer;
import org.ansj.app.keyword.Keyword;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

public class WordTest {
	
	public static void main(String[] args) {
		String str = "华为(HUAWEI)M3 8.4英寸 平板电脑(2560x1600 麒麟950 哈曼卡顿音效 4G/32G WiFi)日晖金" ;
		System.out.println(ToAnalysis.parse(str));
		System.out.println(NlpAnalysis.parse(str));
		
		KeyWordComputer kwc = new KeyWordComputer(10);
		List<Keyword> words = kwc.computeArticleTfidf(str);
		System.out.println(words);
	}
}
