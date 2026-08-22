class Twitter {

    // followerId -> usuários que ele segue
    Map<Integer, Set<Integer>> following;

    // userId -> tweets publicados por ele
    Map<Integer, List<Tweet>> posts;

    // contador global para determinar a ordem dos tweets
    int timestamp;

    public Twitter() {
        following = new HashMap<>();
        posts = new HashMap<>();
        timestamp = 0;
    }

    public void postTweet(int userId, int tweetId) {

        // Se o usuário ainda não possui tweets,
        // cria uma lista para ele.
        if (!posts.containsKey(userId)) {
            posts.put(userId, new ArrayList<>());
        }

        // O timestamp aumenta a cada novo tweet.
        timestamp++;

        Tweet tweet = new Tweet(tweetId, timestamp);

        posts.get(userId).add(tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        // MinHeap baseado no timestamp.
        // O tweet mais antigo fica no topo.
        PriorityQueue<Tweet> minHeap =
            new PriorityQueue<>((a, b) -> a.timestamp - b.timestamp);

        // Primeiro, adicionamos os tweets do próprio usuário.
        if (posts.containsKey(userId)) {

            for (Tweet tweet : posts.get(userId)) {

                minHeap.offer(tweet);

                // Mantemos apenas os 10 tweets mais recentes.
                if (minHeap.size() > 10) {
                    minHeap.poll();
                }
            }
        }

        // Depois adicionamos os tweets dos usuários seguidos.
        if (following.containsKey(userId)) {

            for (int followedUser : following.get(userId)) {

                if (!posts.containsKey(followedUser)) {
                    continue;
                }

                for (Tweet tweet : posts.get(followedUser)) {

                    minHeap.offer(tweet);

                    // Mantemos apenas os 10 mais recentes.
                    if (minHeap.size() > 10) {
                        minHeap.poll();
                    }
                }
            }
        }

        // O minHeap possui os 10 mais recentes,
        // mas do mais antigo para o mais novo.
        //
        // Por isso precisamos construir a resposta
        // de trás para frente.
        LinkedList<Integer> feed = new LinkedList<>();

        while (!minHeap.isEmpty()) {
            feed.addFirst(minHeap.poll().id);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {

        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }

        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (!following.containsKey(followerId)) {
            return;
        }

        following.get(followerId).remove(followeeId);
    }
}

class Tweet {

    int id;
    int timestamp;

    public Tweet(int id, int timestamp) {
        this.id = id;
        this.timestamp = timestamp;
    }
}