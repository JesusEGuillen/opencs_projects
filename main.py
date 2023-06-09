# Import necessary libraries
import numpy as np
import cv2

# Initialize video capture object and face/eye cascade classifiers
cap = cv2.VideoCapture(0)
face_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_frontalface_default.xml')
eye_cascade = cv2.CascadeClassifier(cv2.data.haarcascades + 'haarcascade_eye.xml')

# Define font and scale for labeling
font = cv2.FONT_HERSHEY_SIMPLEX
font_scale = 1

# Initialize face and eye counters
face_counter = 0
eye_counter = 0

# Loop over video frames until 'q' key is pressed
while True:
    # Capture video frame
    ret, frame = cap.read()

    # Convert video frame to grayscale
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)

    # Detect faces in grayscale frame
    faces = face_cascade.detectMultiScale(gray, 1.3, 5)

    # Update face counter
    face_counter = len(faces)

    # Loop over detected faces
    for (x, y, w, h) in faces:
        # Draw rectangle around face on original color frame
        cv2.rectangle(frame, (x, y), (x + w, y + h), (255, 0, 0), 5)
        # Add label for "face"
        cv2.putText(frame, 'face', (x, y - 10), font, font_scale, (255, 0, 0), 2)

        # Extract region of interest (ROI) in grayscale and color
        roi_gray = gray[y:y+w, x:x+w]
        roi_color = frame[y:y+h, x:x+w]

        # Detect eyes in ROI grayscale
        eyes = eye_cascade.detectMultiScale(roi_gray, 1.3, 5)

        # Update eye counter
        eye_counter = len(eyes)

        # Loop over detected eyes
        for (ex, ey, ew, eh) in eyes:
            # Draw rectangle around eye on color ROI frame
            cv2.rectangle(roi_color, (ex, ey), (ex + ew, ey + eh), (0, 255, 0), 5)
            # Add label for "eye"
            cv2.putText(roi_color, 'eye', (ex, ey - 10), font, font_scale, (0, 255, 0), 2)

    # Add text box for face and eye counters
    cv2.rectangle(frame, (10, 10), (200, 100), (255, 255, 255), -1)
    cv2.putText(frame, 'Faces: {}'.format(face_counter), (20, 40), font, font_scale, (0, 0, 0), 2)
    cv2.putText(frame, 'Eyes: {}'.format(eye_counter), (20, 80), font, font_scale, (0, 0, 0), 2)

    # Show video frame with detected faces/eyes
    cv2.imshow('frame', frame)

    # Break loop if 'q' key is pressed
    if cv2.waitKey(1) == ord('q'):
        break

# Release video capture object and close all windows
cap.release()
cv2.destroyAllWindows()
