package com.example.morningintentsapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest


class MainActivity : AppCompatActivity() {
    var buttonSms :Button ?=null
    var buttonEmail:Button ?=null
    var buttonCamera :Button ?=null
    var buttonShare :Button ?=null
    var buttonCall :Button ?=null
    var buttonmpesa:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSms =findViewById(R.id.mBtnsms)
        buttonEmail =findViewById(R.id.mbtnemail)
        buttonCamera =findViewById(R.id.mBtnCamera)
        buttonShare =findViewById(R.id.mBtnShare)
        buttonCall =findViewById(R.id.buttonCall)
        buttonmpesa =findViewById(R.id.mBtnMpesa)

        buttonSms!!.setOnClickListener{
            val uri: Uri = Uri.parse("smsto:0716899177")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "The SMS text")
            startActivity(intent)
        }
        buttonmpesa!!.setOnClickListener{
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
        buttonCamera!!.setOnClickListener{
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
        }
        buttonEmail!!.setOnClickListener{
            val emailIntent =
                Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "abc@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
        buttonShare!!.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")
            startActivity(shareIntent)

        }
        buttonCall!!.setOnClickListener{
     }
    }

    }
    //create an application with 4page
    //on the 1st page place 3 respective button linking you on three different pages
    //on the second page, implement a simple calculator
    //on the third page , display a website of you choice
    //on the last page. implement the six intent cover on today class