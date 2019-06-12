package exam;

import java.util.List;

// TODO: 瀹屾垚杩欎釜绫�

public class PaginationHelper<I> {

	public int itemsPerPage;
    public List<I> collection;
    /**
     * 鏋勯�犲嚱鏁板寘鍚�
     * 1锛夋暟缁刢ollection锛岃〃绀洪渶瑕佸垎椤电殑鎵�鏈夊厓绱�
     * 2锛夋暟瀛梚temsPerPage锛岃〃绀烘瘡椤电殑鍏冪礌涓暟
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection=collection;
        this.itemsPerPage=itemsPerPage;
    }

    /**
     * 杩斿洖collection涓墍鏈夊厓绱犵殑涓暟
     */
    public int itemCount() {
        return this.collection.size();
    }

    /**
     * 杩斿洖椤垫暟
     */
    public int pageCount() {
    	int page=this.itemsPerPage;
    	int total=this.collection.size();
    	int count=total/page +1;
        return count;
    }

    /**
     * 杩斿洖褰撳墠椤祊ageIndex涓墍鍖呭惈鐨勫厓绱犱釜鏁�
     * pageIndex浠�0寮�濮嬭鏁�
     * 濡傛灉pageIndex涓洪潪娉曞�煎垯杩斿洖-1
     */
    public int pageItemCount(int pageIndex) {
    	int pages=this.pageCount();
    	int page=this.collection.size()%this.itemsPerPage;
    	int count=0;
    	if(pageIndex < 0 || pageIndex >= pages)
    		count=-1;
    	else 
    	{
    		if(page!=0 && pageIndex==(pages-1))
    			count=page;
    		else
    			count=this.itemsPerPage;
    	}
        return count;
    }

    /**
     * 杩斿洖绗琲temIndex涓厓绱犳墍鍦ㄧ殑椤垫暟
     * pageIndex浠�0寮�濮嬭鏁�
     * 濡傛灉itemIndex涓洪潪娉曞�煎垯杩斿洖-1
     */
    public int pageIndex(int itemIndex) {
    	int index=0;
    	if(itemIndex>0&&itemIndex<=this.collection.size())
    		index=itemIndex/this.itemsPerPage;
    	else
    		index=-1;
    		
        return index;
    }
}