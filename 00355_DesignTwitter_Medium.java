/*Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, and is able to see the 10 most recent tweets in the user's news feed.
Implement the Twitter class:
Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
  Example 1:
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]

Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
  Constraints:
1 <= userId, followerId, followeeId <= 500
0 <= tweetId <= 104
All the tweets have unique IDs.
At most 3 * 104 calls will be made to postTweet, getNewsFeed, follow, and unfollow.*/
 
class Twitter {
    
    Map<Integer,Info> users = new HashMap<Integer,Info>();
    
    int k=0;
        
    class Info{
        int id;
        List<Integer> follows;
        List<Tweet> tweets;
        public Info(int id){
            this.id = id;
            follows = new ArrayList<Integer>();
            follow(id);
            tweets = new ArrayList<Tweet>();
        }
        public void follow(int followee){
            follows.add(followee);
        }   
        
        public String toString(){
            return id+" follows-> "+follows +" tweets-> " +tweets;
        }
    }
    
    class Tweet{
        int id;
        int date;
        public Tweet(int d,int id){
            this.id=id;
            this.date=d;
        }
         public String toString(){
            return id+" "+date ;
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!users.containsKey(userId)){
           Info i =new Info(userId); 
           users.put(userId,i);
        }
        
        Info info = users.get(userId);
        info.tweets.add(new Tweet(++k,tweetId));
   //     System.out.println(users);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user 
        followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
     //   System.out.println(users);
        if(!users.containsKey(userId)){
            return new ArrayList<Integer>();
        }else{
            List<Tweet> all =new ArrayList<Tweet>();
            Info info = users.get(userId);
            for(Integer x :info.follows){
                Info ai = users.get(x);
                all.addAll(ai.tweets);
            }
            Collections.sort(all,new Comparator<Tweet>(){
                     public int compare(Tweet s1,Tweet s2){
                           return (s2.date-s1.date);
                     }});
            List<Integer> ret =new ArrayList<Integer>();
            for(Tweet x :all){
                ret.add(x.id);
            }
            return ret.size()>10?ret.subList(0,10):ret;
        } 
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
           Info i =new Info(followerId); 
           users.put(followerId,i);
        }
        if(!users.containsKey(followeeId)){
           Info i =new Info(followeeId); 
           users.put(followeeId,i);
        }
        if(!users.get(followerId).follows.contains(followeeId))
        users.get(followerId).follows.add(followeeId);
        //System.out.println(users);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(users.containsKey(followerId)){
           Info info =  users.get(followerId);
           info.follows.remove(new Integer(followeeId));
        }
     //   System.out.println(users);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
