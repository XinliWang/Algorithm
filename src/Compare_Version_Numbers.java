/**
 * Compare two version numbers version1 and version2.
 If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

 You may assume that the version strings are non-empty and contain only digits and the . character.
 The . character does not represent a decimal point and is used to separate number sequences.
 For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

 Here is an example of version numbers ordering:

 0.1 < 1.1 < 1.2 < 13.37
 */
public class Compare_Version_Numbers {
    public int compareVersion(String version1,String version2){
        //we need to use escape characters \\ for .
        String[] versionArray1 = version1.split("\\.");
        String[] versionArray2 = version2.split("\\.");
        int size1 = versionArray1.length;
        int size2 = versionArray2.length;
        int maxSize = Math.max(size1,size2);
        //we use the max of array to compare, if one of them uses up,then we use 0 to be its value each time
        for(int i=0,first=0,second=2;i<maxSize;i++,first=0,second=0){
            if(i<size1)first = Integer.parseInt(versionArray1[i]);
            if(i<size2)second = Integer.parseInt(versionArray2[i]);
            if(first>second)return 1;
            else if(first<second)return -1;
        }
        return 0;
    }
}
