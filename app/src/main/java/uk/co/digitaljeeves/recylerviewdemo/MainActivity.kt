package uk.co.digitaljeeves.recylerviewdemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val fruitsList = listOf<Fruit>(
        Fruit("Mango","Joe"),
        Fruit("Apple", "Barry"),
        Fruit("Banana", "Bob"),
        Fruit("Guava", "Lenny") ,
        Fruit("Strawberry", "Susan"),
        Fruit("Peach", "Karina"),
        Fruit("Pear", "Percival"),
        Fruit("Orange", "Karen"),
        Fruit("Passion Fruit", "Terry"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rvMainList)
        recyclerView.setBackgroundColor(Color.YELLOW)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitsList) { selectedItem: Fruit ->
            listItemClicked(selectedItem)
        }
    }
    private fun listItemClicked(fruit: Fruit){
        Toast.makeText(this, "Selected fruit is ${fruit.name} from ${fruit.supplier}", Toast.LENGTH_SHORT).show()
    }
}