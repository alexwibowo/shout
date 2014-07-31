Shout
==============

Ever wish you can scream within your log files (so that it is blatantly obvious when you scroll through it)? Now you can!


```
 import static com.github.alexwibowo.shout.ShoutGenerator.ShoutStyle.BOLD;
 import static com.github.alexwibowo.shout.ShoutGenerator.ShoutStyle.ITALIC;
 import static com.github.alexwibowo.shout.ShoutGenerator.shout;
 ..
 ..
 LOGGER.warn(shout("EXPLODE"));
 LOGGER.warn(shout("CAREFUL",  BOLD, 25));
```

Too easy!