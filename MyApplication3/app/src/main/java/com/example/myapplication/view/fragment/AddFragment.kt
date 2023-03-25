package com.example.myapplication.view.fragment

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.Contacts.Intents.Insert.ACTION
import android.provider.ContactsContract.Intents.Insert.ACTION
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.myapplication.viewmodel.AddViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddBinding
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

class AddFragment : Fragment() {
    private val REQUEST_CODE = 2000
    private lateinit var binding: FragmentAddBinding
    private lateinit var addViewModel: AddViewModel
    companion object {
        fun newInstance() = AddFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_add,
            container,
            false
        )
        addViewModel = AddViewModel()
        binding.gallery.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setDataAndType(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                "image/*"
            )
            startActivityForResult(intent, REQUEST_CODE)

        }

        binding.someId.setOnClickListener {
            addViewModel.imagePost()
        }

        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.data != null) {
            var selectedImageUri: Uri = data.data!!
            var filepath = MediaStore.Images.Media.DATA
            var cursor = requireActivity().contentResolver.query(selectedImageUri,
                arrayOf(filepath), null ,null, null)
            cursor!!.moveToFirst()

            var culumnIndex = cursor.getColumnIndex(filepath[0].toString())



            var picpath = cursor.getString(culumnIndex)
            cursor.close()
            val file = Uri.fromFile(File(picpath))
            Log.d("TAG", file.toString())
//            var requestBody : RequestBody = RequestBody.create(MediaType.parse("image/*"),file)
//            var body : MultipartBody.Part = MultipartBody.Part.createFormData("image", file.name,requestBody)
//            addViewModel.body.postValue(body)
//            binding.imgGallery.setImageURI(selectedImageUri)
        }
    }

}