package com.example.myapplication.view.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.myapplication.viewmodel.AddViewModel
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    private lateinit var binding: FragmentAddBinding
    companion object {
        fun newInstance() = AddFragment()
    }

    private lateinit var viewModel: AddViewModel

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
        binding.someId.setOnClickListener {
            // Registers a photo picker activity launcher in single-select mode.
            val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                // Callback is invoked after the user selects a media item or closes the
                // photo picker.
                if (uri != null) {
                    Log.d("PhotoPicker", "Selected URI: $uri")
                } else {
                    Log.d("PhotoPicker", "No media selected")
                }
            }

// Include only one of the following calls to launch(), depending on the types
// of media that you want to allow the user to choose from.

// Launch the photo picker and allow the user to choose images and videos.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))

// Launch the photo picker and allow the user to choose only images.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))

// Launch the photo picker and allow the user to choose only videos.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VideoOnly))

// Launch the photo picker and allow the user to choose only images/videos of a
// specific MIME type, such as GIFs.
            val mimeType = "image/gif"
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.SingleMimeType(mimeType)))
        }
        return inflater.inflate(R.layout.fragment_add, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddViewModel::class.java)
        // TODO: Use the ViewModel
    }

}