package com.ji.studymykotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ji.studymykotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         val binding = ActivityMainBinding.inflate(layoutInflater);

        setContentView(binding.root)
        with(binding){
            tv.text
        }

//        studyRun()

    }

    // 스코프 함수
    // run, let, apply, also
    // with
    // 1. run
    fun studyRun(){
        val phones = mutableListOf("010-1234-5678","010-3456-8978","010-4587-1345")
        val list = mutableListOf(1,2,3,4,5,6,7,8,9)
        var names = mutableListOf("Scott", "kelly", "Michael")

        var seoulPeople = SeoulPeople()

        val resultRun = seoulPeople.persons.run {
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            size
        }

        Log.d("스코프함수", "resultRun=$resultRun")

        val resultLet =seoulPeople.persons.let { persons->
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
        }

        Log.d("스코프함수", "resultLet=$resultLet")

        val resultApply =seoulPeople.persons.apply {
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            add(Person("Scott", "010-1234-5678", 22))
            11
        }

        Log.d("스코프함수", "resultApply=$resultApply")

        val resultAlso = seoulPeople.persons.also {
                persons->
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
            persons.add(Person("Scott", "010-1234-5678", 22))
            12
        }


    }

}

class SeoulPeople{
    var persons = mutableListOf<Person>()
    init{
    }

}

data class Person(
    var name:String = "",
    var phone:String = "",
    var age:Int = 21
)
