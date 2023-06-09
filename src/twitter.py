import tweepy
import time

# consumer_key = "rI7TjlWaAY5zzea3Q4lW2mvwu"
# consumer_secret = "GjB9sJUmdfKe8VWm79dpBGRFOD39jj9HSb8JJhAbTr26kkbnb7"
# access_token = "924722624390983680-Il0bifEUVC9BubiRbVA6F7DuepLxWDN"
# access_token_secret = "aqVFJRO047lFsn0t7ZdtEjrPOI3yLcG3wt49mbH13yS9o"

auth = tweepy.OAuthHandler(consumer_key, consumer_secret)
auth.set_access_token(access_token, access_token_secret)
api = tweepy.API(auth)

tweet_id = "1665029495307350016?s=46&t=nDA5teviE0iP3mUjxm9VzA"
custom_message = "@elonmusk!"

while True:
    api.update_status(f"{custom_message} \n\n{tweet_id}")
    print("Le tweet a été retweeté avec succès.")
    time.sleep(10)
