object CiserCipher {
  def main(args:Array[String]): Unit ={
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    //encryption algorithm
    val E=(c:Char,key:Int,a:String)=> a((a.indexOf(c.toUpper)+key)%a.size)
    //Decryption algorithm
    val D=(c:Char,key:Int,a:String)=> a(if((a.indexOf(c.toUpper)-key)%a.size >=0) (a.indexOf(c.toUpper)-key)%a.size else a.size+(a.indexOf(c.toUpper)-key)%a.size)

    val cipher: ((Char, Int, String) => Char, String, Int, String) => String = (algo: (Char, Int, String) => Char, s: String, key: Int, a: String) => s.map(algo(_, key, a))

    print("Enter a string:")
    val s:String = scala.io.StdIn.readLine()
    print("Enter the key value:")
    val key:Int = scala.io.StdIn.readInt()
    val ct: String = cipher(E,s,key, alphabet)
    println(ct)
    val pt: String = cipher(D, ct,key, alphabet)
    println(pt)

  }
}

